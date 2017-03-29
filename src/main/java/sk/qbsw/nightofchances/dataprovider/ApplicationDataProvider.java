package sk.qbsw.nightofchances.dataprovider;

import sk.qbsw.nightofchances.model.domain.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * The application data provider.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class ApplicationDataProvider
{
	private static final List<Application> APPLICATIONS = new ArrayList<>();

	static
	{
		APPLICATIONS.add(Application.newBuilder().id(1L).key("CM").name("CityMonitor").build());
		APPLICATIONS.add(Application.newBuilder().id(2L).key("HCS").name("HC Slovan").build());
		APPLICATIONS.add(Application.newBuilder().id(3L).key("MC").name("MedusaCard").build());
	}

	public static List<Application> findAll ()
	{
		return APPLICATIONS;
	}

	public static Application findById (String key)
	{
		return APPLICATIONS.stream().filter(a -> key.equals(a.getKey())).findFirst().orElseGet(null);
	}
}
