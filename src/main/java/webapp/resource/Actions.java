/*
 * Copyright (c) 2023 University of Padua, Italy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package webapp.resource;

/**
 * Contains constants for the actions performed by the application.
 *
 * @author Nicola Ferro
 * @version 1.00
 * @since 1.00
 */
public final class Actions {

	/**
	 * The creation of an employee
	 */
	public static final String CREATE_PERSON = "CREATE_PERSON";

	/**
	 * This class can be neither instantiated nor sub-classed.
	 */
	private Actions() {
		throw new AssertionError(String.format("No instances of %s allowed.", Actions.class.getName()));
	}
}