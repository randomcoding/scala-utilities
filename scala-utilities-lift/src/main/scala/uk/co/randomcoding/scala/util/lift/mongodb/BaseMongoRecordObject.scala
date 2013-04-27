/**
 * Copyright (C) 2012 - RandomCoder <randomcoder@randomcoding.co.uk>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *    RandomCoder <randomcoder@randomcoding.co.uk> - initial API and implementation and/or initial documentation
 */
package uk.co.randomcoding.scala.util.lift.mongodb

import org.bson.types.ObjectId
import net.liftweb.mongodb.record.MongoMetaRecord
import net.liftweb.mongodb.record.MongoRecord
import net.liftweb.mongodb.record.field.ObjectIdPk

/**
 * Provides common functionality for record companion objects to find matching records and find records by id.
 *
 * Requires that the type `T extend MongoRecord[T] with ObjectIdPk[T]`
 *
 * Users of this trait are required to implement the `findById(org.bson.types.ObjectId)` and
 * `matchingRecord(T)` methods.
 *
 * @author RandomCoder <randomcoder@randomcoding.co.uk>
 *
 * Created On: 29 Jul 2012
 */
trait BaseMongoRecordObject[T <: MongoRecord[T] with ObjectIdPk[T]] {

  /**
   * Find a record by its object id - typically its `id` or `_id` field.
   *
   * Should return `Some(record)` if there is a record of ths type with the given object id or `None` if there is not.
   */
  def findById(oid: ObjectId): Option[T]

  /**
   * Find a record that matched the input one, if one is present in the database.
   *
   * The definition of a match is left up to the implementer, but it is often good to be
   * consistent with the companion classes `equals` method.
   *
   * This method is only required to return a single match, even if there are multiple matches in the database,
   * so the exact match strategy and precedence is left up to the implementor.
   *
   * As this is primarily used (by me) to check that there are no matching records present, then this is sufficient.
   *
   * @return An optional record if there is a match found, or `None` if there are no records that match.
   */
  def matchingRecord(t: T): Option[T]

  /**
   * Updates the record with the given `ObjectId` with the values from the new record.
   *
   * If there is no record with the given `ObjectId` then this method '''should not''' add the
   * new record, it should return `None`.
   *
   * If there is a record with the given `ObjectId` then that record should have all its values set to the
   * ones in the new record. The updated record should be returned inside an Option.
   */
  final def update(oid: ObjectId, newT: T): Option[T] = findById(oid) match {
    case Some(record) => newT.id(oid).saveTheRecord
    case _ => None
  }

  /**
   * Remove the record with the given `ObjectId` from the collection of this type.
   *
   * @return The removed record, or if there is no record with the given `ObjectId`,
   * or if the remove operation fails `None`
   */
  final def remove(oid: ObjectId): Option[T] = findById(oid) match {
    case Some(record) => if (record.delete_!) Some(record) else None
    case _ => None
  }

  /**
   * Finds a ''matching'' record in the database.
   *
   * A ''match'' is made if:
   *
   *  - There is another record with the same Object Id
   *  - A record is returned from the [[uk.co.randomcoding.scala.util.lift.mongodb.BaseMongoRecordObject#matchingRecord(T)]]
   *
   * @return The optional match, or `None` if there is no match
   */
  final def findMatching(t: T): Option[T] = findById(t.id.get) match {
    case Some(r) => Some(r)
    case _ => matchingRecord(t)
  }

  /**
   * Add a new record to the database unless there is a matching record.
   *
   * If there is a matching record then '''do not''' add the new one.
   *
   * A match is determined by calling the `findMatching(T)` method,
   * with a return value of Some(t) indicating there is a matching record.
   *
   * @return The optionally added record, or if there is a match then the matched record.
   */
  final def add(t: T): Option[T] = findMatching(t) match {
    case Some(t) => Some(t)
    case _ => t.saveTheRecord
  }
}
