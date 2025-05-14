import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

class MapNotificationDAO implements NotificationDAO {
    private final Map<UUID, NotificationVO> notifications = new HashMap<>();

    public UUID addNotification(Date time, String message) {
        UUID id = UUID.randomUUID();
        notifications.put(id, new NotificationVO(time, message));
        return id;
    }

    public NotificationVO getNotification(UUID id) {
        return notifications.get(id);
    }
}
