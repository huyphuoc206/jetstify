export const isPlaying = state => state.isPlaying;

export const currentSong = state => state.currentSong;

export const currentSongId = state => state.currentSong ? state.currentSong.songId : null;

export const songs = state => state.songs;