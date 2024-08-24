# Bus Booking Ticket Desktop Software

This project is a simple Java-based system for managing administrative tasks and displaying available routes and times. It includes functionalities for reading and displaying admin credentials, routes, and schedules. The code demonstrates basic file handling, string manipulation, and object-oriented programming principles.

## Project Structure

### `Admin` Class
The `Admin` class is responsible for handling administrative tasks, including:
- Storing and retrieving admin credentials from a file (`Admin.txt`).
- Displaying available routes and times from external files (`patternplace.txt` and `patternset.txt`).

#### Key Methods:
- `readAdminLogin()`: Reads admin credentials from `Admin.txt`.
- `displayRoutesAvailable()`: Reads route data from `patternplace.txt` and formats it for display.
- `displayTimeAvailable()`: Reads time data from `patternset.txt` and formats it for display.

### `Main` Class
The `Main` class serves as the entry point for the application. It currently initializes the application with a `HomePage` instance, but other commented-out code indicates possible future functionalities, such as staff login, profile updates, and staff management.

## File Structure

- `Admin.txt`: Stores admin credentials in the format `username,password`.
- `patternplace.txt`: Contains route information with departure and arrival points, and route prices.
- `patternset.txt`: Contains available time slots.

## Usage

1. **Initialize Admin**:
   - Create an instance of `Admin` to read and store admin credentials.
   
2. **Display Routes**:
   - Call `displayRoutesAvailable()` method to get a formatted list of all available routes.
   
3. **Display Times**:
   - Call `displayTimeAvailable()` method to get a formatted list of all available times.

## Example

```java
public class Main {
    public static void main(String[] args) throws Exception {
        Admin admin = new Admin();
        System.out.println(admin.displayRoutesAvailable());
        System.out.println(admin.displayTimeAvailable());
    }
}
```

## Notes

- Ensure that the `Admin.txt`, `patternplace.txt`, and `patternset.txt` files are correctly formatted and located in the project directory.
- The `Admin` class handles exceptions but does not provide detailed error messages. Consider enhancing error handling for production use.

## Future Enhancements

- Implement detailed error logging.
- Add GUI components for better user interaction.
- Extend functionalities to include staff management and profile updates.
