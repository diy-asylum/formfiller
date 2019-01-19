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

  // so that the element names are unique across sections
  const fixId = elt => {
    elt.elementName = `${name}.${elt.elementName}`;
  };

  formElements.forEach(fixId);

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
