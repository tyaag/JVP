class NotificationVO {
    private final Date notificationDate;
    private final String notificationMessage;

    public NotificationVO(Date notificationDate, String notificationMessage) {
        this.notificationDate = notificationDate;
        this.notificationMessage = notificationMessage;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }
}
