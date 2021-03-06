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
package uk.co.randomcoding.scala.util.core.string

/**
 * Helper functions for string types
 *
 * @author RandomCoder <randomcoder@randomcoding.co.uk>
 *
 * Created On: 18 Jul 2012
 */
object StringHelpers {
  /**
   * Generates a space separated string from an input where the first letter of each word is capitalised and the rest are not.
   *
   * @param inString The string to reformat
   * @param splitOn The regex used to locate the matches to split the input string at
   *
   * @return A reformatted string
   */
  def firstLetterCaps(inString: String, splitOn: String = """\s"""): String = {
    inString.split(splitOn).map(elem => elem.charAt(0).toUpper + elem.substring(1).toLowerCase).mkString("", " ", "")
  }
}