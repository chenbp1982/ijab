/*
 * tigase-xmpp4gwt
 * Copyright (C) 2007 "Bartosz Małkowski" <bmalkow@tigase.org>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. Look for COPYING file in the top folder.
 * If not, see http://www.gnu.org/licenses/.
 *
 * $Rev$
 * Last modified by $Author$
 * $Date$
 */
package anzsoft.xmpp4gwt.client.xmpp.xeps.vcard;

import anzsoft.xmpp4gwt.client.JID;
import anzsoft.xmpp4gwt.client.Plugin;
import anzsoft.xmpp4gwt.client.PluginState;
import anzsoft.xmpp4gwt.client.Session;
import anzsoft.xmpp4gwt.client.citeria.Criteria;
import anzsoft.xmpp4gwt.client.packet.Packet;
import anzsoft.xmpp4gwt.client.stanzas.IQ;

public class VCardPlugin implements Plugin {

	private Session session;

	public VCardPlugin(Session session) {
		this.session = session;
	}

	public Criteria getCriteria() 
	{
		return null;
		/*
		return ElementCriteria.name("iq").add(
				ElementCriteria.name("vCard", new String[] { "xmlns" }, new String[] { "vcard-temp" }));
		*/
	}

	public PluginState getStatus() {
		return null;
	}

	public boolean process(Packet element) {
		return false;
	}

	public void reset() 
	{
	}

	public void vCardRequest(final JID jid, final VCardResponseHandler handler) 
	{
		IQ iq = new IQ(IQ.Type.get);
		iq.setAttribute("id", "" + Session.nextId());
		if (jid != null)
			iq.setAttribute("to", jid.toStringBare());

		iq.addChild("vCard", "vcard-temp");

		session.addResponseHandler(iq, handler);
	}

}
