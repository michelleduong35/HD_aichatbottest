import React, { useState, useEffect } from "react";
import "./App.css";
import { createTherapist, sendMessageToBackend } from "./api/openai";

function App() {
  const [messages, setMessages] = useState([]);
  const [userInput, setUserInput] = useState("");

  useEffect(() => {
    createTherapist();
  }, []);

  const handleSend = () => {
    const newMessage = { text: userInput, sender: "user" };
    setMessages([...messages, newMessage]);
    setUserInput("");
    // Call a function to send this message to backend
    sendMessageToBackend(newMessage.text);
  };

  return (
    <div className="App">
      <div>
        <h1>ai chat bot</h1>
        <input type="text" placeholder="Type your message here..." />
        <button onClick={handleSend}>Send</button>
      </div>
    </div>
  );
}

export default App;
