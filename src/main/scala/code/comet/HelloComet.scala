package code.comet

import net.liftweb.common.Logger
import net.liftweb.http.{SHtml, CometActor}
import net.liftweb.http.js.JE.JsRaw
import net.liftweb.http.js.JsCmds.SetHtml
import net.liftweb.http.js.JsCmds

/**
 *
 *
 * User: Tyson Hamilton
 * Date: 05/06/12
 * Time: 9:30 AM
 *
 */

class HelloComet extends CometActor with Logger {

  def alert(msg: String) = {
    this ! Some("DO IT")
    JsCmds.jsExpToJsCmd(JsRaw("alert('%s')".format(msg)))
  }

  def render = {
    ":button [onclick]" #> SHtml.ajaxCall(JsRaw("this.id"), s => alert("Message: %s".format(s)))
  }

  override def lowPriority: PartialFunction[Any, Unit] = {
    case Some(msg) => partialUpdate(SetHtml("msg", <span>COMET POW</span>))
  }
}
