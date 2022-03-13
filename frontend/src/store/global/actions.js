import * as TYPES from "./types";

export const randomQuote = async ({ commit }) => {
  const res = await fetch("https://api.quotable.io/random");
  const data = await res.json();
  commit(TYPES.RANDOM_PAGE_TITLE, data.content);
};
