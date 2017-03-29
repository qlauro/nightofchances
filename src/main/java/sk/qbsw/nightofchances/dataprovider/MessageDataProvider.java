package sk.qbsw.nightofchances.dataprovider;

import sk.qbsw.nightofchances.model.domain.Message;
import sk.qbsw.nightofchances.model.domain.ValidityState;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

/**
 * The message data provider.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class MessageDataProvider
{
	private static final List<Message> MESSAGES = new ArrayList<>();

	private static final OffsetDateTime MARCH_THE_FIRST = OffsetDateTime.of(2017, 3, 1, 10, 00, 00, 00, ZoneOffset.UTC);

	static
	{
		MESSAGES.add(Message.newBuilder().id(1L).created(MARCH_THE_FIRST).validFrom(MARCH_THE_FIRST) //
			.alert("Welcome to CityMonitor").title("Welcome to CityMonitor").application(ApplicationDataProvider.findById("CM")).state(ValidityState.VALID).build());
		MESSAGES.add(Message.newBuilder().id(2L).created(MARCH_THE_FIRST).validFrom(MARCH_THE_FIRST) //
			.alert("Found new broken road").title("Found new broken road").application(ApplicationDataProvider.findById("CM")).state(ValidityState.DELETED).build());
	}

	public static List<Message> findAll ()
	{
		return MESSAGES;
	}

	public static Message findById (Long id)
	{
		return MESSAGES.stream().filter(m -> m.getId().equals(id)).findFirst().orElseGet(null);
	}
}
