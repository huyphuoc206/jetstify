import * as TYPES from "./types";

export const setPlaying = ({ commit }, isPlaying) => {
    commit(TYPES.SET_PLAYING, isPlaying);
}

export const playSong = ({ commit, getters }, song) => {
    setCurrentSong({ commit }, song);
    addSong({ commit, getters }, { song: song, isQueue: false });
}

export const addSong = ({ commit, getters }, { song, isQueue }) => {
    const songs = [...getters.songs];
    if (isQueue) {
        songs.push(song);
    } else {
        songs.unshift(song);
    }
    commit(TYPES.SET_SONGS, songs);
}

export const setCurrentSong = ({ commit }, song) => {
    commit(TYPES.SET_CURRENT_SONG, song);
}

export const nextPrevSong = ({ commit, getters }, isNext) => {
    const songs = getters.songs;
    const currentSong = getters.currentSong;
    const currentSongIndex = songs.findIndex(song => song.songId === currentSong.songId);
    let newCurrentSong;
    if (isNext) {
        newCurrentSong = currentSongIndex === songs.length - 1 ? songs[0] : songs[currentSongIndex + 1];
    } else {
        newCurrentSong = currentSongIndex === 0 ? songs[songs.length - 1] : songs[currentSongIndex - 1];
    }
    setCurrentSong({ commit }, newCurrentSong);
}