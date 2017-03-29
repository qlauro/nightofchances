package sk.qbsw.nightofchances.model.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

/**
 * The notification entity.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class Notification extends Entity
{
	private static final long serialVersionUID = -1325917744252223450L;

	@NotNull
	private OffsetDateTime created = OffsetDateTime.now();

	private OffsetDateTime sent;

	private OffsetDateTime delivered;

	private OffsetDateTime read;

	@NotNull
	private NotificationState state = NotificationState.NEW;

	@NotNull
	private Message message;

	@NotNull
	private Registration registration;

	private Notification (Builder builder)
	{
		setId(builder.id);
		setCreated(builder.created);
		setSent(builder.sent);
		setDelivered(builder.delivered);
		setRead(builder.read);
		setState(builder.state);
		setMessage(builder.message);
		setRegistration(builder.registration);
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

	public OffsetDateTime getSent ()
	{
		return sent;
	}

	public void setSent (OffsetDateTime sent)
	{
		this.sent = sent;
	}

	public OffsetDateTime getDelivered ()
	{
		return delivered;
	}

	public void setDelivered (OffsetDateTime delivered)
	{
		this.delivered = delivered;
	}

	public OffsetDateTime getRead ()
	{
		return read;
	}

	public void setRead (OffsetDateTime read)
	{
		this.read = read;
	}

	public NotificationState getState ()
	{
		return state;
	}

	public void setState (NotificationState state)
	{
		this.state = state;
	}

	public Message getMessage ()
	{
		return message;
	}

	public void setMessage (Message message)
	{
		this.message = message;
	}

	public Registration getRegistration ()
	{
		return registration;
	}

	public void setRegistration (Registration registration)
	{
		this.registration = registration;
	}

	@Override
	public boolean equals (Object o)
	{
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Notification that = (Notification) o;

		return new EqualsBuilder().appendSuper(super.equals(o)).append(created, that.created).append(sent, that.sent).append(delivered, that.delivered).append(read, that.read).append(state, that.state).append(message, that.message).append(registration, that.registration).isEquals();
	}

	@Override
	public int hashCode ()
	{
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(created).append(sent).append(delivered).append(read).append(state).append(message).append(registration).toHashCode();
	}

	public static final class Builder
	{
		private Long id;
		private OffsetDateTime created;
		private OffsetDateTime sent;
		private OffsetDateTime delivered;
		private OffsetDateTime read;
		private NotificationState state;
		private Message message;
		private Registration registration;

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

		public Builder sent (OffsetDateTime val)
		{
			sent = val;
			return this;
		}

		public Builder delivered (OffsetDateTime val)
		{
			delivered = val;
			return this;
		}

		public Builder read (OffsetDateTime val)
		{
			read = val;
			return this;
		}

		public Builder state (NotificationState val)
		{
			state = val;
			return this;
		}

		public Builder message (Message val)
		{
			message = val;
			return this;
		}

		public Builder registration (Registration val)
		{
			registration = val;
			return this;
		}

		public Notification build ()
		{
			return new Notification(this);
		}
	}
}
