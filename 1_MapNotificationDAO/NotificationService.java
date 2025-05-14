import java.util.Date;
import java.util.UUID;

public class NotificationService {
    private final NotificationDAO storage;

    public NotificationService(NotificationDAO storage) {
        this.storage = storage;
    }

    public UUID raiseNotification(String message) {
        return this.storage.addNotification(new Date(), message);
    }

    public Date getNotificationTime(UUID id) {
        NotificationVO vo = this.storage.getNotification(id);
        return vo != null ? vo.getNotificationDate() : null;
    }

    public String getNotificationMessage(UUID id) {
        NotificationVO vo = this.storage.getNotification(id);
        return vo != null ? vo.getNotificationMessage() : null;
    }

    public static void main(String[] args) throws java.io.IOException {
        if (args.length < 1) {
            System.out.println("Please provide count of alerts as first argument.");
            return;
        }

        int count = Integer.parseInt(args[0]);
        java.io.BufferedReader reader = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));

        NotificationService service = new NotificationService(new MapNotificationDAO());
        java.util.List<UUID> ids = new java.util.ArrayList<>();

        for (int i = 0; i < count; i++) {
            String message = reader.readLine();
            UUID id = service.raiseNotification(message);
            ids.add(id);
        }

        System.out.println("\nStored Notifications:");
        for (UUID id : ids) {
            System.out.println("ID: " + id);
            System.out.println("Time: " + service.getNotificationTime(id));
            System.out.println("Message: " + service.getNotificationMessage(id));
            System.out.println();
        }
    }
}
