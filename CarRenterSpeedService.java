import java.util.HashMap;
import java.util.Map;

// Interface for NotificationService
interface NotificationService {
    void sendNotification(String message);
}

// Firebase implementation of NotificationService
class FirebaseNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Simulating a Firebase notification
        System.out.println("Firebase Notification Sent: " + message);
        // Here, you'd call the Firebase API to send the notification
    }
}

// AWS implementation of NotificationService (Placeholder for future implementation)
class AWSNotificationService implements NotificationService {
    @Override
    public void sendNotification(String message) {
        // Placeholder for AWS notification
        System.out.println("AWS Notification Sent: " + message);
        // Call AWS API to send the notification
    }
}

// Renter class to encapsulate customer details
class Renter {
    private final String name;
    private final int maxSpeed;

    public Renter(String name, int maxSpeed) {
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public String getName() {
        return name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}

// CarRentalSystem to manage renters and speed monitoring
class CarRentalSystem {
    private final Map<String, Renter> renters = new HashMap<>();
    private NotificationService notificationService;

    public CarRentalSystem(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    // Register a renter with their maximum speed
    public void registerRenter(String renterId, String name, int maxSpeed) {
        renters.put(renterId, new Renter(name, maxSpeed));
    }

    // Simulate speed monitoring
    public void monitorSpeed(String renterId, int currentSpeed) {
        Renter renter = renters.get(renterId);
        if (renter == null) {
            System.out.println("Renter not found: " + renterId);
            return;
        }

        if (currentSpeed > renter.getMaxSpeed()) {
            String alert = "Warning! Renter " + renter.getName() + " exceeded the speed limit of " 
                    + renter.getMaxSpeed() + " km/h. Current speed: " + currentSpeed + " km/h.";
            notificationService.sendNotification(alert);
            System.out.println("User Alert: " + alert);
        } else {
            System.out.println("Renter " + renter.getName() + " is within the speed limit.");
        }
    }

    // Switch notification service (Firebase to AWS, for instance)
    public void setNotificationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }
}

public class Main {
    public static void main(String[] args) {
        // Initialize the system with Firebase as the default notification service
        NotificationService firebaseService = new FirebaseNotificationService();
        CarRentalSystem carRentalSystem = new CarRentalSystem(firebaseService);

        // Register renters with different speed limits
        carRentalSystem.registerRenter("renter1", "Alice", 80);
        carRentalSystem.registerRenter("renter2", "Bob", 100);

        // Simulate speed monitoring
        carRentalSystem.monitorSpeed("renter1", 90); // Exceeds limit
        carRentalSystem.monitorSpeed("renter2", 95); // Within limit

        // Switch to AWS for notifications (future scenario)
        NotificationService awsService = new AWSNotificationService();
        carRentalSystem.setNotificationService(awsService);

        // Simulate speed monitoring with AWS
        carRentalSystem.monitorSpeed("renter1", 85); // Exceeds limit
    }
}
