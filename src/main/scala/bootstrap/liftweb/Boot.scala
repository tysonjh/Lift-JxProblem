package bootstrap.liftweb

import net.liftweb.sitemap.{Loc, Menu, SiteMap}
import net.liftweb.sitemap.Loc.Link
import net.liftweb.common.Full
import net.liftweb.http.{Html5Properties, Req, LiftRules}


/**
 * A class that's instantiated early and run.  It allows the application
 * to modify lift's environment
 */
class Boot {
  def boot {

    // where to search snippet
    LiftRules.addToPackages("code")

    // Build SiteMap
    def sitemap = SiteMap(
      Menu.i("Home") / "index", // the simple way to declare a menu
      Menu.i("Hello World") / "HelloWorld",
      Menu.i("Hello Comet") / "cometHello",
      Menu.i("World Comet") / "cometWorld",
      // more complex because this menu allows anything in the
      // /static path to be visible
      Menu(Loc("Static", Link(List("static"), true, "/static/index"), "Static Content")))

//    def sitemapMutators = User.sitemapMutator

    // set the sitemap.  Note if you don't want access control for
    // each page, just comment this line out.
//    LiftRules.setSiteMapFunc(() => sitemapMutators(sitemap))

    LiftRules.setSiteMap(sitemap)

    // Use jQuery 1.4
    LiftRules.jsArtifacts = net.liftweb.http.js.jquery.JQuery14Artifacts

    //Show the spinny image when an Ajax call starts
    LiftRules.ajaxStart = Full(() => LiftRules.jsArtifacts.show("ajax-loader").cmd)
    
    // Make the spinny image go away when it ends
    LiftRules.ajaxEnd = Full(() => LiftRules.jsArtifacts.hide("ajax-loader").cmd)

    // Force the request to be UTF-8
    LiftRules.early.append(_.setCharacterEncoding("UTF-8"))

    // Use HTML5 for rendering
    LiftRules.htmlProperties.default.set((r: Req) => new Html5Properties(r.userAgent))

  }
}
