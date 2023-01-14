import {IWord} from "./iword";
import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class DictionaryService {

  dictionaryView: IWord | undefined;

  dictionaryList: IWord[] = [
    {id:1 ,word: "like", mean: "thích"},
    {id:2 ,word: "like", mean: "thích"},
    {id:3 ,word: "like", mean: "thích"},
    {id:4 ,word: "like", mean: "thích"},
    {id:5 ,word: "like", mean: "thích"},
    {id:6 ,word: "like", mean: "thích"},
    {id:7 ,word: "like", mean: "thích"}
  ];

  constructor() {
  }

  getAll() {
    return this.dictionaryList;
  }


  findDictionary(index: number | undefined) {
    this.dictionaryView = this.dictionaryList.find(d=>d.id===index)
    return this.dictionaryView;
  }
}
