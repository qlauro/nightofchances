package sk.qbsw.nightofchances.model.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/**
 * The registration.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class Registration extends Entity
{
	private static final long serialVersionUID = 7075096645616091892L;

	@NotNull
	private OffsetDateTime created = OffsetDateTime.now();

	@NotNull
	private OffsetDateTime updated;

	@NotNull
	private String token;

	@NotNull
	private Platform platform;

	@NotNull
	private Locale locale;

	@NotNull
	private RegistrationState state = RegistrationState.VALID;

	@NotNull
	private Application application;

	private Registration (Builder builder)
	{
		setId(builder.id);
		setCreated(builder.created);
		setUpdated(builder.updated);
		setToken(builder.token);
		setPlatform(builder.platform);
		setLocale(builder.locale);
		setState(builder.state);
		setApplication(builder.application);
	}

	public static Builder newBuilder ()
	{
		return new Builder();
	}

	public Long getId ()
	{
		return id;
	}

	public void setId (Long id)
	{
		this.id = id;
	}

	public OffsetDateTime getCreated ()
	{
		return created;
	}

	public void setCreated (OffsetDateTime created)
	{
		this.created = created;
	}

	public OffsetDateTime getUpdated ()
	{
		return updated;
	}

	public void setUpdated (OffsetDateTime updated)
	{
		this.updated = updated;
	}

	public String getToken ()
	{
		return token;
	}

	public void setToken (String token)
	{
		this.token = token;
	}

	public Platform getPlatform ()
	{
		return platform;
	}

	public void setPlatform (Platform platform)
	{
		this.platform = platform;
	}

	public Locale getLocale ()
	{
		return locale;
	}

	public void setLocale (Locale locale)
	{
		this.locale = locale;
	}

	public RegistrationState getState ()
	{
		return state;
	}

	public void setState (RegistrationState state)
	{
		this.state = state;
	}

	public Application getApplication ()
	{
		return application;
	}

	public void setApplication (Application application)
	{
		this.application = application;
	}

	@Override
	public boolean equals (Object o)
	{
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Registration that = (Registration) o;

		return new EqualsBuilder().appendSuper(super.equals(o)).append(updated, that.updated).append(created, that.created).append(token, that.token).append(platform, that.platform).append(locale, that.locale).append(state, that.state).append(application, that.application).isEquals();
	}

	@Override
	public int hashCode ()
	{
		return new HashCodeBuilder(15, 89).append(created).append(updated).append(token).append(platform).append(locale).append(state).append(application).toHashCode();
	}

	@Override
	public String toString ()
	{
		return "Registration{" + "id=" + id + ", created=" + created + ", updated=" + updated + ", token='" + token + '\'' + ", platform=" + platform + ", locale=" + locale + ", state=" + state + ", application=" + application + "'}'";
	}

	public static final class Builder
	{
		private Long id;
		private OffsetDateTime created = OffsetDateTime.now();
		private OffsetDateTime updated;
		private String token;
		private Platform platform;
		private Locale locale;
		private RegistrationState state = RegistrationState.VALID;
		private Application application;
		private Set<Notification> notifications = new HashSet<>();

		private Builder ()
		{
		}

		public Builder id (Long val)
		{
			id = val;
			return this;
		}

		public Builder created (OffsetDateTime val)
		{
			created = val;
			return this;
		}

		public Builder updated (OffsetDateTime val)
		{
			updated = val;
			return this;
		}

		public Builder token (String val)
		{
			token = val;
			return this;
		}

		public Builder platform (Platform val)
		{
			platform = val;
			return this;
		}

		public Builder locale (Locale val)
		{
			locale = val;
			return this;
		}

		public Builder state (RegistrationState val)
		{
			state = val;
			return this;
		}

		public Builder application (Application val)
		{
			application = val;
			return this;
		}

		public Builder notifications (Set<Notification> val)
		{
			notifications = val;
			return this;
		}

		public Registration build ()
		{
			return new Registration(this);
		}
	}
}
