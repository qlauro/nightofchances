package sk.qbsw.nightofchances.model.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * The abstract entity.
 *
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public abstract class Entity implements Serializable
{
	private static final long serialVersionUID = 8403460499619143694L;

	@NotNull
	protected Long id;

	public Long getId ()
	{
		return id;
	}

	public void setId (Long id)
	{
		this.id = id;
	}

	@Override
	public boolean equals (Object o)
	{
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		Entity entity = (Entity) o;

		return new EqualsBuilder().append(id, entity.id).isEquals();
	}

	@Override
	public int hashCode ()
	{
		return new HashCodeBuilder(125, 225).append(id).toHashCode();
	}
}
