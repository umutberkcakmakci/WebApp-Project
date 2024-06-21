# WebApp-Project
Movie Webapp is a movie application, including user interactions and member relationships. The developed website enables users to personalize their interface, add preferred movies, access information about actors and directors, and explore a catalog of popular films. This project is developed using HTML, CSS, JavaScript (Frontend) , Java (Backend) and Postgres database. Also it includes  documentation in LaTeX format.

## Prerequisites
- Java Runtime Environment (JRE)
Backend application requires to have java installed.
- Web server (e.g., Apache Tomcat)
Java is installed for the application, including any necessary configurations for Tomcat.
- Database
A Postgres DB needs to be already created! For testing you can use postgres.
On /src/main/database you can find the sql script to create the tables and insert some data.
- Web browser

## Getting Started
To set up your project locally, you need to clone the repository and install the dependencies.
Clone the repository:
```bash 
git clone https://<USERNAME>@bitbucket.org/upd-dei-stud-prj/webgroup.git
```
Ensure you have PostgreSQL configured properly in IntelliJ before proceeding.

## Directory Structure

The project has the following main directories:

* `.idea`
* `metadata`
* `.settings`
* `bin`
* `src`
    * `main`
        * `database`
        * `java`
            * `webapp`
                * `DAO`
                * `resource`
                * `rest`
                * `servlet`
                * `utils`
        * `resources`
        * `webapp`
            * `html`
            * `css`
            * `jsp`
            * `js`
            * `META-INF`
            * `WEB-INF`
* `target`
* `.classpath`
* `.project`
* `nb-configuration.xml`
* `pom.xml`


### Detailed Directory Description

- **database**: Likely contains database-related scripts or configurations.
- **java**: Contains Java source code.
  - `webapp`: Main packages for the web application.
    - **DAO**: Data Access Object layer, responsible for database interactions.
    - **resource**: Contains resource files.
    - **rest**: REST services.
    - **servlet**: Contains servlets, which handle HTTP requests and responses.
    - **utils**: Utility classes and helper methods.
- **webapp**: Web application specific files.
  - `html/`: HTML files for the web pages.
  - `css/`: Stylesheets for the web pages.
  - `jsp/`: JavaServer Pages, used for dynamic web content.
  - `js/`: JavaScript files for client-side scripting.
  - `META-INF/`: Metadata files for the web application.
  - `WEB-INF/`: Contains web application configuration files like `web.xml`.

## How to Run (Steps)
1. **Setup the Web Server:**
   - Ensure your web server (e.g., Apache Tomcat) is installed and running.

2. **Deploy the Application:**
   - Copy the contents of the `Webapp Project` directory to your web servers deployment directory (e.g., `webapps` in Tomcat).

3. **Access the Application:**
   - Open a web browser and navigate to `http://localhost:8080/your-app-context` (replace `your-app-context` with the actual context path of your application).

## Project Documentation
The project includes a detailed report in the `WebEdge_HW1_Report` directory, which contains LaTeX files for different sections of the report. To compile the report, you will need a LaTeX editor and compiler (e.g., TeXShop, Overleaf).


## Contributing

| Last Name             | First Name            | Student Number |
| --------------------- | --------------------- | -------------- |
| BIMAJ                 | KEJSI                 | 2112145        |
| CAKMAKCI              | UMUT BERK             | 2071408        |
| MUHAMMAD              | ALI                   | 2071499        |
| TIKHONOV              | VLADISLAV             | 2106920        |
| YANOGLU               | MELTEM                | 2071545        |

