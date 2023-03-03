$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("featurefiles/Intreview.feature");
formatter.feature({
  "name": "To validate the myntra web application",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "User shopping for the Tshirts",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "To launch the web browser",
  "keyword": "Given "
});
formatter.match({
  "location": "MyntraReg.toLaunchTheWebBrowser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To open the url of myntra website",
  "keyword": "When "
});
formatter.match({
  "location": "MyntraReg.toOpenTheUrlOfMyntraWebsite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To type and search the Tshirt product",
  "keyword": "And "
});
formatter.match({
  "location": "MyntraReg.toTypeAndSearchTheTshirtProduct()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To select the first product and select M size",
  "keyword": "And "
});
formatter.match({
  "location": "MyntraReg.toSelectTheFirstProductAndSelectMSize()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "To click Add to bag button",
  "keyword": "And "
});
formatter.match({
  "location": "MyntraReg.toClickAddToBagButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "TO click the bag icon",
  "keyword": "And "
});
formatter.match({
  "location": "MyntraReg.toClickTheBagIcon()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Take screenshot of the payment page",
  "keyword": "Then "
});
formatter.match({
  "location": "MyntraReg.takeScreenshotOfThePaymentPage()"
});
formatter.result({
  "status": "passed"
});
});