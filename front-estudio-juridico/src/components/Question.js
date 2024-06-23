import * as React from 'react';
import Box from '@mui/material/Box';
import { Button } from '@mui/material';
import TextField from '@mui/material/TextField';
import { TextareaAutosize as BaseTextareaAutosize } from '@mui/base/TextareaAutosize';
import { useState } from 'react';


export default function Question() {
  let today = new Date();
  let date=today.getDate() + "-"+ parseInt(today.getMonth()+1) +"-"+today.getFullYear();

  const [fullName, setFullName]=useState('')
  const [email, setEmail]=useState('')
  const [phoneNumber, setPhoneNumber]=useState('')
  const [message, setMessage]=useState('')


  const handleClick=(e)=>{
    e.preventDefault()
    const question={date, fullName, email, phoneNumber, message}
    console.log(question)
    fetch("http://localhost:8080/v1/questions",{
      method:"POST",
      headers:{"Content-Type": "application/json"},
      body: JSON.stringify(question)

  }).then(()=>{
    console.log("New question added.")
    })
}

  return (

    <Box
      component="form"
      sx={{
        '& > :not(style)': { m: 1, width: '25ch' },
      }}
      noValidate
      autoComplete="off"
    >
      <h1 style={{color:"#F9F6F3"}}>CONTÁCTENOS</h1>
      <TextField id="outlined-basic" label="Nombre Completo" variant="outlined" fullWidth value={fullName} onChange={(e)=>setFullName(e.target.value)}/>
      <TextField id="outlined-basic" label="Correo electrónico" variant="outlined" fullWidth value={email} onChange={(e)=>setEmail(e.target.value)}/>
      <TextField id="outlined-basic" label="Teléfono" variant="outlined" fullWidth value={phoneNumber} onChange={(e)=>setPhoneNumber(e.target.value)}/>
      <BaseTextareaAutosize maxRows={6} aria-label="maximum height" placeholder="Escriba su consulta en forma breve." defaultValue="Consulta" fullWidth value={message} onChange={(e)=>setMessage(e.target.value)}/>
      <Button variant="contained" onClick={handleClick}>ENVIAR</Button>
    </Box>
  );
}