# Fashion-ReactJS_Springboot

### Backend (Spring Boot) - Database Setup:
1. **Create MySQL Database:**
   - Before running the backend, ensure you have MySQL installed and running on your system.
   - Create a MySQL database named `ecommerce` using your preferred MySQL client or the command line.

2. **Configure Database Connection:**
   - Open the `application.properties` file located in `spring-boot/src/main/resources`.
   - Set up the database connection properties:
     ```
     spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
     spring.datasource.username=root
     spring.datasource.password=root
     ```

### Backend (Spring Boot) - Start Application:
1. **Navigate to the Backend Directory:**
   ```bash
   cd spring-boot

2. **Build the Project with Maven:**
   ```bash
   mvn clean install

3. **Run the Spring Boot Application:**
   ```bash
   mvn spring-boot:run

4. **Access the Backend:**
- Once the application is running, the backend will be available at `http://localhost:5454`.

### Frontend (ReactJS):
1. **Navigate to the Frontend Directory:**
   ```bash
   cd react
   
2. **Install Dependencies:**
   ```bash
   npm install
   
3. **Start the Development Server:**
   ```bash
   npm start

5. **Access the Frontend:**
- The React app will be served at `http://localhost:3000`.

### Note:
- Ensure you have MySQL installed and configured properly on your system.
- Replace `localhost`, `3306`, `root`, and `root` with your MySQL host, port, username, and password respectively, if they are different in your environment.
- You may need to adjust the commands slightly based on your operating system or environment setup.





 
