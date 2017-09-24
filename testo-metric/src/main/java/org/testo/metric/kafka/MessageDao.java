package org.testo.metric.kafka;

import org.testo.core.repository.BaseDao;
import org.testo.metric.model.Message;

public interface MessageDao extends BaseDao {

	public String save(Message message) throws Exception;
}
