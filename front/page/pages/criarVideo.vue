<template>
    <div class="formsss">
        <cab><h1>ADICIONAR VÍDEO</h1></cab>
        <v-sheet class="mx-auto" width="60%" >
    <v-form fast-fail @submit.prevent="submitForm">
        <v-text-field
        v-model="titulo"
        label="Título"
      ></v-text-field>
      <v-text-field
        v-model="capa"
        label="Capa"
      ></v-text-field>
      <v-text-field
        v-model="descricao"
        label="Descrição"
      ></v-text-field>


      <v-file-input prepend-icon="mdi-camera"  clearable label="Envie uma imagem de capa" variant="outlined"></v-file-input>
      <v-file-input  prepend-icon="mdi-video"  clearable label="Carregar video" variant="outlined"></v-file-input>
      <v-btn class="mt-12" type="submit"  block>Submit</v-btn>
    </v-form>
  </v-sheet>
    </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
const route = useRoute();
const router = useRouter();
const titulo = ref('');
const capa = ref('');
const descricao = ref('');


const submitForm = async () => {
  try {
    const DADOS = {
        titulo: titulo.value,
        capa: capa.value,
        descricao: descricao.value
    };

    const response = await axios.post('http://localhost:8077/Videos', DADOS, {
        headers: {
            'Content-Type': 'application/json'
        }
    });

   
    
    
    console.log('Dados enviados com sucesso:', response.data);
    titulo.value = '';
    capa.value = '';
    descricao.value = '';
    router.push('/videos');
} catch (error) {
    console.error('Erro ao enviar dados:', error);
}

};
</script>

<style  scoped>
.mx-auto{
    margin: 80px;
    align-self: flex-start;

}
.v-input{
    margin: 30px;
    padding: 20px;
}
.mt-2 {
    width: 100px; /* Adjust this value to your preference */
}
</style>