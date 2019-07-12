import React, {useState, useEffect} from 'react';
import logo from './logo.svg';
import './App.css';
import Form from './QuestionAnswerForm'
import axios from 'axios';
import cardLibrary from './GetCardData'

function App() {

  const url = "http://localhost:8080/api/flashcards/"
  const [card, updateCard] = useState({});
  const [cardNo, updateCardNo] = useState(1)
  useEffect( () => {   
    async function getCard(no){
      cardLibrary.updateStage(no);
      updateCardNo(2);
    }  
    getCard(cardNo);
  }, []); 

  

  

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p> 
          {card.question}
        </p> 
      </header> 
      <Form/>
    </div>
  );
}

export default App;
