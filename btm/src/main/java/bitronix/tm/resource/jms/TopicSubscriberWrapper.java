/*
 * Bitronix Transaction Manager
 *
 * Copyright (c) 2010, Bitronix Software.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA 02110-1301 USA
 */
package bitronix.tm.resource.jms;

import javax.jms.TopicSubscriber;
import javax.jms.Topic;
import javax.jms.JMSException;

/**
 * {@link TopicSubscriber} wrapper that adds XA enlistment semantics.
 *
 * @author lorban
 */
public class TopicSubscriberWrapper extends MessageConsumerWrapper implements TopicSubscriber {

    public TopicSubscriberWrapper(TopicSubscriber topicSubscriber, DualSessionWrapper session, PoolingConnectionFactory poolingConnectionFactory) {
        super(topicSubscriber, session, poolingConnectionFactory);
    }

    public Topic getTopic() throws JMSException {
        return ((TopicSubscriber) getMessageConsumer()).getTopic();
    }

    public boolean getNoLocal() throws JMSException {
        return ((TopicSubscriber) getMessageConsumer()).getNoLocal();
    }

    public String toString() {
        return "a TopicSubscriberWrapper of " + session;
    }

}