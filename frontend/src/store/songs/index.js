import * as getters from "./getters";
import * as actions from "./actions";

const initState = () => ({
    songs: [{
            name: "Nơi này có anh",
            artist: "Sơn Tùng MTP",
            img: "https://i.ytimg.com/vi/FN7ALfpGxiI/maxresdefault.jpg",
        },
        {
            name: "Chill Music",
            artist: "",
            img: "https://th.bing.com/th/id/OIP.UOxkfqh5bdAdqka3KSWUyAHaEK?pid=ImgDet&rs=1",
        },
        {
            name: "Có Chàng Trai Viết Lên Cây",
            artist: "Phan Mạnh Quỳnh",
            img: "https://th.bing.com/th/id/OIP.6DFU43oDDEZv6WuvhfuD7AHaEK?pid=ImgDet&rs=1",
        },
        {
            name: "3107",
            artist: "W/n",
            img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
        },
        {
            name: "3107",
            artist: "W/n",
            img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
        },
        {
            name: "3107",
            artist: "W/n",
            img: "https://th.bing.com/th/id/OIP.FYZ0pOovTJt_0u8gFMUUogHaEK?pid=ImgDet&rs=1",
        },
    ],
});

const mutations = {
    FETCH_SONG(state, songs) {
        state.songs = songs;
    },
};

export default {
    namespaced: true,
    state: initState(),
    getters,
    actions,
    mutations,
};