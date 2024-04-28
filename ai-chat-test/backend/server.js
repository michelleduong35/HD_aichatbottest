const express = require("express");
const { Configuration, OpenAIApi } = require("openai");

const app = express();
const port = process.env.PORT || 5000;

const configuration = new Configuration({
  apiKey: process.env.OPENAI_API_KEY,
});
const openai = new OpenAIApi(configuration);

app.use(express.json());

app.post("/create-assistant", async (req, res) => {
  try {
    const assistant = await openai.beta.assistants.create({
      name: "Therapist",
      instructions:
        "You are a therapist. Write and run code to give users advice to their issues, and give them affirmations.",
      tools: [{ type: "code_interpreter" }],
      model: "gpt-3.5-turbo-1106",
    });
    res.json(assistant.data); // Send back the newly created assistant details
  } catch (error) {
    console.error("Failed to create assistant:", error);
    res.status(500).send("Error creating assistant");
  }
});

app.listen(port, () => {
  console.log(`Server listening on port ${port}`);
});
