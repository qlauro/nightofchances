package sk.qbsw.nightofchances.dataprovider;

import sk.qbsw.nightofchances.model.domain.Platform;
import sk.qbsw.nightofchances.model.domain.Registration;
import sk.qbsw.nightofchances.model.domain.RegistrationState;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The registration data provider.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class RegistrationDataProvider
{
	private static final List<Registration> REGISTRATIONS = new ArrayList<>();

	private static final OffsetDateTime MARCH_THE_FIRST = OffsetDateTime.of(2017, 3, 1, 10, 00, 00, 00, ZoneOffset.UTC);

	private static final Locale DEFAULT_LOCALE = new Locale("sk", "sk");

	static
	{
		REGISTRATIONS.add(Registration.newBuilder().id(1L).created(MARCH_THE_FIRST).updated(MARCH_THE_FIRST.minusDays(10)) //
			.token("registration-CM-1").platform(Platform.ANDROID).locale(DEFAULT_LOCALE).state(RegistrationState.VALID).application(ApplicationDataProvider.findById("CM")).build());
		REGISTRATIONS.add(Registration.newBuilder().id(2L).created(MARCH_THE_FIRST).updated(MARCH_THE_FIRST.minusDays(9)) //
			.token("registration-CM-2").platform(Platform.ANDROID).locale(DEFAULT_LOCALE).state(RegistrationState.VALID).application(ApplicationDataProvider.findById("CM")).build());
		REGISTRATIONS.add(Registration.newBuilder().id(2L).created(MARCH_THE_FIRST).updated(MARCH_THE_FIRST.minusDays(8)) //
			.token("registration-CM-3").platform(Platform.ANDROID).locale(DEFAULT_LOCALE).state(RegistrationState.INVALID).application(ApplicationDataProvider.findById("CM")).build());
	}

	public static List<Registration> findAll ()
	{
		return REGISTRATIONS;
	}

	public static Registration findById (Long id)
	{
		return REGISTRATIONS.stream().filter(m -> m.getId().equals(id)).findFirst().orElseGet(null);
	}
}
