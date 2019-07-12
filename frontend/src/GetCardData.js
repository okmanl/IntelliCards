import axios from 'axios';

export default {
  getCardData(cardNo){
    const url = "http://localhost:8080/api/flashcards/" + cardNo;
    return axios.get(url)
    .then(function (response) {
      // handle success
      console.log(response);
      return response.data;
    })
    .catch(function (error) {
      // handle error
      console.log(error);
      return error;
    });
  },

  updateStage(cardNo){
    const url = "http://localhost:8080/api/flashcards/" + cardNo;
    this.getCardData(cardNo).then( (card) => { return Object.assign(card, {stage: card.stage+1})}  ).then( (updatedCard) => axios.put(url, updatedCard) );
  }
}