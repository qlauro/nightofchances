package sk.qbsw.nightofchances.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import sk.qbsw.nightofchances.model.domain.Entity;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The sync collection.
 *
 * @param <E> the type parameter
 * @author Tomas Lauro
 * @version 1.0.0
 * @since 1.0.0
 */
public class SyncCollection<E extends Entity> implements Serializable
{
	private static final long serialVersionUID = -8070131612352999231L;

	private List<E> updated = new ArrayList<>();

	private List<Long> deleted = new ArrayList<>();

	@NotNull
	private OffsetDateTime lastUpdated;

	public SyncCollection (List<E> updated, List<Long> deleted, OffsetDateTime lastUpdated)
	{
		this.updated = updated;
		this.deleted = deleted;
		this.lastUpdated = lastUpdated;
	}

	public List<E> getUpdated ()
	{
		return updated;
	}

	public void setUpdated (List<E> updated)
	{
		this.updated = updated;
	}

	public List<Long> getDeleted ()
	{
		return deleted;
	}

	public void setDeleted (List<Long> deleted)
	{
		this.deleted = deleted;
	}

	public OffsetDateTime getLastUpdated ()
	{
		return lastUpdated;
	}

	public void setLastUpdated (OffsetDateTime lastUpdated)
	{
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString ()
	{
		return "SyncCollection{" + "updated=" + updated + ", deleted=" + deleted + ", lastUpdated=" + lastUpdated + '}';
	}

	@Override
	public boolean equals (Object o)
	{
		if (this == o) return true;

		if (o == null || getClass() != o.getClass()) return false;

		SyncCollection<?> that = (SyncCollection<?>) o;

		return new EqualsBuilder().append(updated, that.updated).append(deleted, that.deleted).append(lastUpdated, that.lastUpdated).isEquals();
	}

	@Override
	public int hashCode ()
	{
		return new HashCodeBuilder(17, 37).append(updated).append(deleted).append(lastUpdated).toHashCode();
	}
}
