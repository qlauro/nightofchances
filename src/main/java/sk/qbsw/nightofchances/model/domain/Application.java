package sk.qbsw.nightofchances.model.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;

/**
 * The application.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class Application extends Entity
{
	private static final long serialVersionUID = -9047947153547814700L;

	@NotNull
	private String key;

	@NotNull
	private String name;

	@NotNull
	private ValidityState state = ValidityState.VALID;

	private Application (Builder builder)
	{
		setId(builder.id);
		setKey(builder.key);
		setName(builder.name);
		setState(builder.state);
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

	public String getKey ()
	{
		return key;
	}

	public void setKey (String key)
	{
		this.key = key;
	}

	public String getName ()
	{
		return name;
	}

	public void setName (String name)
	{
		this.name = name;
	}

	public ValidityState getState ()
	{
		return state;
	}

	public void setState (ValidityState state)
	{
		this.state = state;
	}

	@Override
	public boolean equals (Object o)
	{
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Application that = (Application) o;

		return new EqualsBuilder().appendSuper(super.equals(o)).append(key, that.key).append(name, that.name).append(state, that.state).isEquals();
	}

	@Override
	public int hashCode ()
	{
		return new HashCodeBuilder(17, 37).appendSuper(super.hashCode()).append(key).append(name).append(state).toHashCode();
	}

	@Override
	public String toString ()
	{
		return "Application{" + "id=" + id + ", key='" + key + '\'' + ", name='" + name + '\'' + ", state=" + state + '}';
	}

	public static final class Builder
	{
		private Long id;
		private String key;
		private String name;
		private ValidityState state = ValidityState.VALID;

		private Builder ()
		{
		}

		public Builder id (Long val)
		{
			id = val;
			return this;
		}

		public Builder key (String val)
		{
			key = val;
			return this;
		}

		public Builder name (String val)
		{
			name = val;
			return this;
		}

		public Builder state (ValidityState val)
		{
			state = val;
			return this;
		}

		public Application build ()
		{
			return new Application(this);
		}
	}
}
