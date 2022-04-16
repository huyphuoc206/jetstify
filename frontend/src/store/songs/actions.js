import axios from "axios";

export const fetchSong = async({ commit }) => {
    try {
        const res = await axios.get("http://localhost:3000/songs");
        commit("FETCH_SONG", res.data);
    } catch (error) {
        console.log(error);
    }
};