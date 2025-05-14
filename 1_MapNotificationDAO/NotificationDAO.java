interface NotificationDAO {
    UUID addNotification(Date time, String message);
    NotificationVO getNotification(UUID id);
}
