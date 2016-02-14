package com.farming.app.frontEnd;

import com.farming.app.frontEnd.EMF;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.CollectionResponse;
import com.google.appengine.api.datastore.Cursor;
import com.google.appengine.datanucleus.query.JPACursorHelper;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Named;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Api(name = "answersendpoint", namespace = @ApiNamespace(ownerDomain = "farming.com", ownerName = "farming.com", packagePath = "app.frontEnd"))
public class AnswersEndpoint {

	/**
	 * This method lists all the entities inserted in datastore.
	 * It uses HTTP GET method and paging support.
	 *
	 * @return A CollectionResponse class containing the list of all entities
	 * persisted and a cursor to the next page.
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	@ApiMethod(name = "listAnswers")
	public CollectionResponse<Answers> listAnswers(
			@Nullable @Named("cursor") String cursorString,
			@Nullable @Named("limit") Integer limit) {

		EntityManager mgr = null;
		Cursor cursor = null;
		List<Answers> execute = null;

		try {
			mgr = getEntityManager();
			Query query = mgr.createQuery("select from Answers as Answers");
			if (cursorString != null && cursorString != "") {
				cursor = Cursor.fromWebSafeString(cursorString);
				query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
			}

			if (limit != null) {
				query.setFirstResult(0);
				query.setMaxResults(limit);
			}

			execute = (List<Answers>) query.getResultList();
			cursor = JPACursorHelper.getCursor(execute);
			if (cursor != null)
				cursorString = cursor.toWebSafeString();

			// Tight loop for fetching all entities from datastore and accomodate
			// for lazy fetch.
			for (Answers obj : execute)
				;
		} finally {
			mgr.close();
		}

		return CollectionResponse.<Answers> builder().setItems(execute)
				.setNextPageToken(cursorString).build();
	}

	/**
	 * This method gets the entity having primary key id. It uses HTTP GET method.
	 *
	 * @param id the primary key of the java bean.
	 * @return The entity with primary key id.
	 */
	@ApiMethod(name = "getAnswers")
	public Answers getAnswers(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		Answers answers = null;
		try {
			answers = mgr.find(Answers.class, id);
		} finally {
			mgr.close();
		}
		return answers;
	}

	/**
	 * This inserts a new entity into App Engine datastore. If the entity already
	 * exists in the datastore, an exception is thrown.
	 * It uses HTTP POST method.
	 *
	 * @param answers the entity to be inserted.
	 * @return The inserted entity.
	 */
	@ApiMethod(name = "insertAnswers")
	public Answers insertAnswers(Answers answers) {
		EntityManager mgr = getEntityManager();
		try {
			if (containsAnswers(answers)) {
				throw new EntityExistsException("Object already exists");
			}
			mgr.persist(answers);
		} finally {
			mgr.close();
		}
		return answers;
	}

	/**
	 * This method is used for updating an existing entity. If the entity does not
	 * exist in the datastore, an exception is thrown.
	 * It uses HTTP PUT method.
	 *
	 * @param answers the entity to be updated.
	 * @return The updated entity.
	 */
	@ApiMethod(name = "updateAnswers")
	public Answers updateAnswers(Answers answers) {
		EntityManager mgr = getEntityManager();
		try {
			if (!containsAnswers(answers)) {
				throw new EntityNotFoundException("Object does not exist");
			}
			mgr.persist(answers);
		} finally {
			mgr.close();
		}
		return answers;
	}

	/**
	 * This method removes the entity with primary key id.
	 * It uses HTTP DELETE method.
	 *
	 * @param id the primary key of the entity to be deleted.
	 */
	@ApiMethod(name = "removeAnswers")
	public void removeAnswers(@Named("id") String id) {
		EntityManager mgr = getEntityManager();
		try {
			Answers answers = mgr.find(Answers.class, id);
			mgr.remove(answers);
		} finally {
			mgr.close();
		}
	}

	private boolean containsAnswers(Answers answers) {
		EntityManager mgr = getEntityManager();
		boolean contains = true;
		try {
			Answers item = mgr.find(Answers.class, answers.getId());
			if (item == null) {
				contains = false;
			}
		} finally {
			mgr.close();
		}
		return contains;
	}

	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
