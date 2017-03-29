package sk.qbsw.nightofchances.model.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

/**
 * The message.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class Message extends Entity
{
	private static final long serialVersionUID = 2997601198479307557L;

	@NotNull
	private OffsetDateTime created = OffsetDateTime.now();

	@NotNull
	private OffsetDateTime validFrom;

	@NotNull
	private String alert;

	@NotNull
	private String title;

	@NotNull
	private ValidityState state = ValidityState.VALID;

	@NotNull
	private Application application;

	private Message (Builder builder)
	{
		setCreated(builder.created);
		setId(builder.id);
		setValidFrom(builder.validFrom);
		setAlert(builder.alert);
		setTitle(builder.title);
		setApplication(builder.application);
		setState(builder.state);
	}

	public static Builder newBuilder ()
	{
		return new Builder();
	}

	public OffsetDateTime getCreated ()
	{
		return created;
	}

	public void setCreated (OffsetDateTime created)
	{
		this.created = created;
	}

	public OffsetDateTime getValidFrom ()
	{
		return validFrom;
	}

	public void setValidFrom (OffsetDateTime validFrom)
	{
		this.validFrom = validFrom;
	}

	public String getAlert ()
	{
		return alert;
	}

	public void setAlert (String alert)
	{
		this.alert = alert;
	}

	public String getTitle ()
	{
		return title;
	}

	public void setTitle (String title)
	{
		this.title = title;
	}

	public ValidityState getState ()
	{
		return state;
	}

	public void setState (ValidityState state)
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

		Message message = (Message) o;

		return new EqualsBuilder().appendSuper(super.equals(o)).append(created, message.created).append(validFrom, message.validFrom).append(alert, message.alert).append(title, message.title).append(application, message.application).append(state, message.state).isEquals();
	}

	@Override
	public int hashCode ()
	{
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(created).append(validFrom).append(alert).append(title).append(application).append(state).toHashCode();
	}

	@Override
	public String toString ()
	{
		return "Message{" + "created=" + created + ", id=" + id + ", validFrom=" + validFrom + ", alert='" + alert + '\'' + ", title='" + title + '\'' + ", state=" + state + ", application=" + application + '}';
	}

	public static final class Builder
	{
		private OffsetDateTime created;
		private Long id;
		private OffsetDateTime validFrom;
		private String alert;
		private String title;
		private ValidityState state;
		private Application application;

		private Builder ()
		{
		}

		public Builder created (OffsetDateTime val)
		{
			created = val;
			return this;
		}

		public Builder id (Long val)
		{
			id = val;
			return this;
		}

		public Builder validFrom (OffsetDateTime val)
		{
			validFrom = val;
			return this;
		}

		public Builder alert (String val)
		{
			alert = val;
			return this;
		}

		public Builder title (String val)
		{
			title = val;
			return this;
		}

		public Builder state (ValidityState val)
		{
			state = val;
			return this;
		}

		public Builder application (Application val)
		{
			application = val;
			return this;
		}

		public Message build ()
		{
			return new Message(this);
		}
	}
}
