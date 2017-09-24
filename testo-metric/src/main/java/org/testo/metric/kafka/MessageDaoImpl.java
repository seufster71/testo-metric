package org.testo.metric.kafka;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.testo.core.service.EntityManagerSvc;
import org.testo.core.utils.GlobalConstant;
import org.testo.core.utils.Request;
import org.testo.core.utils.Response;
import org.testo.core.utils.StatusMsg;
import org.testo.metric.model.Message;

@Repository("MessageDao")
@Transactional("transactionManagerA")
public class MessageDaoImpl implements MessageDao {

	@Autowired
	EntityManagerSvc em;

	@Override
	public void item(Request request, Response response) throws Exception {
		
		
	}

	@Override
	public void list(Request request, Response response) throws Exception {
		
		Query query = em.getInstance().createQuery("FROM Message ORDER BY created DESC");
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<?> messages = query.getResultList(); 
		response.getParams().put("messages", messages);
	}

	@Override
	public void save(Request request, Response response) throws Exception {
		Message message = new Message((String) request.getParams().get("jms"));
		em.getInstance().persist(message);
		
		StringBuilder s = new StringBuilder();
		s.append("Saved in metric respository with id ").append(message.getId());
		StatusMsg.addMsg(response, GlobalConstant.SUCCESS, s.toString());
	}

	@Override
	public String save(Message message) throws Exception {
		em.getInstance().persist(message);
		StringBuilder s = new StringBuilder();
		s.append("Saved in metric respository with id ").append(message.getId());
		return s.toString();
	}
	
	
	
}
