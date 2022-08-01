import { convertMinutes } from './time-utils';

export const generateTime = (link) => {
    if (!link) return;
    return new Promise(res => {
        let sound = new Audio(link);
        let duration;
        sound.onloadedmetadata = () => {
            duration = convertMinutes(Math.floor(sound.duration));
            res(duration);
        };
    })

};
