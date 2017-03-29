package sk.qbsw.nightofchances.configuration;

import java.io.Serializable;

/**
 * The path configuration.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class PathConfiguration implements Serializable
{
	public static final String REGISTRATIONS_ROOT_PATH = "/registrations";

	public static final String NOTIFICATIONS_ROOT_PATH = "/notifications";

	public static final String NOTIFICATIONS_MARK_AS_DELIVERED_PATH = "/mark-as-delivered";

	public static final String NOTIFICATIONS_STATISTICS = "/statistics";

	public static final String NOTIFICATIONS_GENERATE_BY_STATE = NOTIFICATIONS_STATISTICS + "/generate-by-state";

	public static final String APPLICATION_ID_PARAM = "application-id";
}
