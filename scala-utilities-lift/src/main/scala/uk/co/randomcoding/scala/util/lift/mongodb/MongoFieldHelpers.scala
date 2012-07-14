/*
 * Copyright (C) 2012 RandomCoder <randomcoder@randomcoding.co.uk>
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
 *    RandomCoder - initial API and implementation and/or initial documentation
 */
package uk.co.randomcoding.scala.util.lift.mongodb

import net.liftweb.record.field._
import net.liftweb.mongodb.record.field.ObjectIdRefField
import org.bson.types.ObjectId
import net.liftweb.mongodb.record.field.ObjectIdRefListField

/**
 * Contains implicit conversions for basic field types to their values. This avoids the continual use of `.get`
 *
 * @author RandomCoder <randomcoder@randomcoding.co.uk>
 */
object MongoFieldHelpers {

  implicit def doubleFieldToDouble(field: DoubleField[_]): Double = field.get

  implicit def intFieldToDouble(field: IntField[_]): Int = field.get

  implicit def stringFieldToString(field: StringField[_]): String = field.get

  implicit def typedIdFieldToId(field: ObjectIdRefField[_, _]): ObjectId = field.get

  implicit def typedListIdFieldToId(field: ObjectIdRefListField[_, _]): List[ObjectId] = field.get
}
