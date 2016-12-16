package com.tpg.pwp

import org.scalatest.selenium.HtmlUnit
import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

class HomeAcceptanceTest extends FlatSpec with GivenWhenThen with Matchers with HtmlUnit {
  val host = "http://localhost:8080"

  val url = s"$host/index.html"

  "Landing on the home page" should "show home page details" in {
    go to url

    pageTitle should be ("Personal Web Portal")
  }
}
