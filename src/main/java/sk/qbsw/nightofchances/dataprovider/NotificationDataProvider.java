package sk.qbsw.nightofchances.dataprovider;

import sk.qbsw.nightofchances.model.domain.Notification;
import sk.qbsw.nightofchances.model.domain.NotificationState;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * The notification data provider.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class NotificationDataProvider
{
	private static final List<Notification> NOTIFICATIONS = new ArrayList<>();

	private static final OffsetDateTime MARCH_THE_FIRST = OffsetDateTime.of(2017, 3, 1, 10, 00, 00, 00, ZoneOffset.UTC);

	static
	{
		// first message
		NOTIFICATIONS.add(Notification.newBuilder().id(1L).created(MARCH_THE_FIRST).state(NotificationState.NEW).sent(MARCH_THE_FIRST.plusDays(1)) //
			.message(MessageDataProvider.findById(1L)).registration(RegistrationDataProvider.findById(1L)).build());
		NOTIFICATIONS.add(Notification.newBuilder().id(2L).created(MARCH_THE_FIRST).state(NotificationState.NEW).sent(MARCH_THE_FIRST.plusDays(2)) //
			.message(MessageDataProvider.findById(1L)).registration(RegistrationDataProvider.findById(1L)).build());
		NOTIFICATIONS.add(Notification.newBuilder().id(3L).created(MARCH_THE_FIRST).state(NotificationState.SENT).sent(MARCH_THE_FIRST.plusDays(3)) //
			.message(MessageDataProvider.findById(1L)).registration(RegistrationDataProvider.findById(1L)).build());
		NOTIFICATIONS.add(Notification.newBuilder().id(4L).created(MARCH_THE_FIRST).state(NotificationState.SENT).sent(MARCH_THE_FIRST.plusDays(4)) //
			.message(MessageDataProvider.findById(1L)).registration(RegistrationDataProvider.findById(1L)).build());
		NOTIFICATIONS.add(Notification.newBuilder().id(5L).created(MARCH_THE_FIRST).state(NotificationState.DELIVERED).sent(MARCH_THE_FIRST.plusDays(5)) //
			.message(MessageDataProvider.findById(1L)).registration(RegistrationDataProvider.findById(1L)).build());
		NOTIFICATIONS.add(Notification.newBuilder().id(6L).created(MARCH_THE_FIRST).state(NotificationState.DELIVERED).sent(MARCH_THE_FIRST.plusDays(6)) //
			.message(MessageDataProvider.findById(1L)).registration(RegistrationDataProvider.findById(1L)).build());

		// second message
		NOTIFICATIONS.add(Notification.newBuilder().id(7L).created(MARCH_THE_FIRST).state(NotificationState.NEW).sent(MARCH_THE_FIRST.plusDays(7)) //
			.message(MessageDataProvider.findById(2L)).registration(RegistrationDataProvider.findById(1L)).build());
		NOTIFICATIONS.add(Notification.newBuilder().id(8L).created(MARCH_THE_FIRST).state(NotificationState.NEW).sent(MARCH_THE_FIRST.plusDays(8)) //
			.message(MessageDataProvider.findById(2L)).registration(RegistrationDataProvider.findById(1L)).build());
	}

	public static List<Notification> findAll ()
	{
		return NOTIFICATIONS;
	}
}
