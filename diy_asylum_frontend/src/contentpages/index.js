import registrationPage from "./registrationPage";
import namePage from "./namePage";
import residencePage from "./residencePage";
import mailingAddressPage from "./usMailingAddressPage";
import demographicsPage from "./demographicsPage";
import immigrationStatusPage from "./immigrationStatusPage";
import travelDocumentsPage from "./travelDocumentsPage.js";
import languagePage from "./languagePage";

// TODO: Let's leave this as javascript code for now. But these are basically
// just data objects, so once the format is pretty settled, we can make them
// raw JSON files and load them from external JSON files, which will play well
// with our i18n framework.

const pages = [
  registrationPage,
  namePage,
  residencePage,
  mailingAddressPage,
  demographicsPage,
  immigrationStatusPage,
  travelDocumentsPage,
  languagePage
];

const seenNames = new Set();
for (const page of pages) {
  if (seenNames.has(page.name)) {
    throw new Error(`Section name ${page.name} is reused`);
  }
  seenNames.add(page.name);
}

export const pageNames = pages.map(page => page.name);
export const numPages = pages.length;

export default pages;
