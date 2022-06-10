export const convertMinutes = (seconds) => {
    const SECOND_TIME = seconds % 60;
    if (seconds < 60) return `00:${seconds}`;
    return `${(seconds - SECOND_TIME) / 60}:${SECOND_TIME}`;
};

export const formatDate = (date) => {
    if(typeof date !== 'string' || date.length === 0) return '';

    const arrDate = date.split('-');
    arrDate[2] = arrDate[2].slice(0, 2);
    const day = arrDate[2].charAt(0) === '0' ? arrDate[2].charAt(1) :  arrDate[2];
    const month = arrDate[1].charAt(0) === '0' ? arrDate[1].charAt(1) :  arrDate[1];
   
    return `${day} thg ${month}`;
}



