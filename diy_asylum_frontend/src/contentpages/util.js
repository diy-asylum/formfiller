export const makeFormElement = ({ elementName, label, inputType, help }) => {
  // TODO: we may want more structure here at some point
  help = help || "";
  return {
    elementName,
    label,
    inputType,
    help
  };
};

export const makeContentPage = ({ name, formElements, help }) => {
  // TODO: we may want more structure here at some point
  help = help || "";

  const seenIds = new Set();
  for (const elt of formElements) {
    if (seenIds.has(elt.elementName)) {
      throw new Error(
        `Element id ${elt.elementName} is repeated in section ${name}`
      );
    }
    seenIds.add(elt.elementName);
  }

  return {
    name,
    formElements,
    help
  };
};

export const makeChoicesType = ({ choices }) => ({
  type: "radio",
  choices: choices
});

export const makeTextType = () => ({
  type: "text"
});

export const makeDateType = () => ({
  type: "date"
});
