import * as TYPES from "./types";
import { $rest } from '@/core/rest-client';

export const randomQuote = async ({ commit }) => {
  const res = $rest.get('/users');
  console.log(res);
  // const res = await fetch("https://api.quotable.io/random");
  // const data = await res.json();
  commit(TYPES.RANDOM_PAGE_TITLE, 'hello');
};
