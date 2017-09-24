package org.testo.metric.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testo.core.service.ServiceProcessor;
import org.testo.core.utils.ErrorMsg;
import org.testo.core.utils.GlobalConstant;
import org.testo.core.utils.Request;
import org.testo.core.utils.Response;

@Service("MessageSvc")
public class MessageSvcImpl implements ServiceProcessor, MessageSvc {

	@Autowired
	MessageDao messageDao;

	@Override
	public void process(Request request, Response response) {
		
		String action = (String) request.getParams().get("action");
		switch (action) {
			case "LIST":
				this.list(request, response);
				break;
			case "ITEM":
				this.item(request, response);
				break;
			case "SAVE":
				this.save(request, response);
				break;
			default:
				ErrorMsg.addMsg(response, GlobalConstant.WARN, "The action does not exist!");
				break;
		}

	}

	
	
	@Override
	public void item(Request request, Response response) {
		try {
			messageDao.item(request, response);
		} catch (Exception e) {
			// Overall failure
			ErrorMsg.addMsg(response, GlobalConstant.FAIL, e.getMessage());
		}
		
	}

	@Override
	public void list(Request request, Response response) {
		try {
			messageDao.list(request, response);
		} catch (Exception e) {
			// Overall failure
			ErrorMsg.addMsg(response, GlobalConstant.FAIL, e.getMessage());
		}
		
	}

	@Override
	public void save(Request request, Response response) {
		try {
			messageDao.save(request, response);
		} catch (Exception e) {
			// Overall failure
			ErrorMsg.addMsg(response, GlobalConstant.FAIL, e.getMessage());
		}
		
	}

	
}
