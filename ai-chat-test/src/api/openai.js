export async function createTherapist() {
  try {
    const response = await fetch("/create-assistant", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
    });
    const data = await response.json();
    console.log("Assistant Created:", data);
    return data; // return the assistant data for further use
  } catch (error) {
    console.error("Failed to create assistant:", error);
  }
}

export async function sendMessageToBackend(message, callback) {
  try {
    const response = await fetch("/message", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ message }),
    });
    const data = await response.json();
    callback(data); // Invoke the callback with the response data
  } catch (error) {
    console.error("Error sending message:", error);
    callback(null, error); // Invoke the callback with null data and an error
  }
}
