/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package webapp.resource;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import static webapp.resource.AbstractResource.JSON_FACTORY;

/**
 *
 * @author Vladislav Tikhonov
 */
public class Person {
    //The name of the person.
    private final String name;
    
    //The surname of the person.
    private final String surname;
    
    //The gender of the person.
    private final String shortBio;
    
    //The role of the person.
    private final String role;
    
    //The birthplace of the person.
    private final String birthplace;
    
    //The birthdate of the person.
    private final Date birthdate;
    
    //The photo of the person.
    private final String photolink;
    
    private Integer id;
    
    public Person(final String name, final String surname, final String shortBio,
            final String birthplace, final Date birthdate,
            final String photolink, final String role) {
        this.name = name;
        this.surname = surname;
        this.shortBio = shortBio;
        this.birthplace = birthplace;
        this.birthdate = birthdate;
        this.photolink = photolink;
        this.role = role;
    }
    
    public final Integer getId(){
        return id;
    }
    
    public final Integer setId(Integer id){
        this.id = id;
        return id;
    }
    
    public final String getName(){
        return name;
    }
    
    //The surname of the person.
    public final String getSurname(){
        return surname;
    }
    
    //The gender of the person.
    public final String getShortBio(){
        return shortBio;
    }
    
    //The role of the person.
    public final String getRole(){
        return role;
    }
    
    //The birthplace of the person.
    public final String getBirthplace(){
        return birthplace;
    }
    
    //The birthdate of the person;
    public final Date getBirthdate(){
        return birthdate;
    }
    
    public final String getPhotolink() {
        return photolink;
    }
    
    public static Person fromJSON(final InputStream in) throws IOException  {

		String jName = null;
		String jSurname = null;
                String jShortBio = null;
                String jBirthplace = null;
                Date jBirthdate = null;
		String jPhotolink = null;
                String jRole = null;

		try {
			final JsonParser jp = JSON_FACTORY.createParser(in);

			while (jp.nextToken() != JsonToken.END_OBJECT) {

				if (jp.getCurrentToken() == JsonToken.FIELD_NAME) {
					switch (jp.getCurrentName()) {
						case "name":
							jp.nextToken();
							jName = jp.getText();
							break;
						case "surname":
							jp.nextToken();
							jSurname = jp.getText();
							break;
						case "shortBio":
							jp.nextToken();
							jShortBio = jp.getText();
							break;
                                                case "birthplace":
							jp.nextToken();
							jBirthplace = jp.getText();
							break;
                                                case "birthdate":
							jp.nextToken();
							jBirthdate = java.sql.Date.valueOf(jp.getText());
							break;
						case "photolink":
							jp.nextToken();
							jPhotolink = jp.getText();
							break;
                                                case "role":
							jp.nextToken();
							jRole = jp.getText();
							break;
					}
				}
			}
		} catch(IOException e) {
			throw e;
		}

		return new Person(jName, jSurname, jShortBio, jBirthplace, jBirthdate, jPhotolink, jRole);
	}
}
