import discord
from discord.ext import commands
import requests
import random
import os
import json

#f = open('mockWeatherAPI.json')

client = commands.Bot(command_prefix= "--")


@client.event
async def on_message(message):

    if message.content.startswith('--hello'):
        reply = message.channel
        await reply.send('Hello! \nWould you like to grow a new plant? **Answer yes/no**')
    elif message.content.startswith('--bot'):
        reply = message.channel
        await reply.send('ayo')
    elif message.content.startswith('--yes'):
        response = "pick your seed \n:tomato: tomato \n:carrot: carrot \n:strawberry: strawberry"
        await message.channel.send(response)
    elif message.content.startswith('--no'):
        await message.channel.send("ok")
    elif message.content.startswith('--tomato'):
        await message.channel.send("yum! Enter your zipcode so that I can access if growing that is good." )


@client.event
async def on_ready():
    print('Logged in')


client.run('TOKEN')
